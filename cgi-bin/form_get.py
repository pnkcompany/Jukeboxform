#!/usr/bin/python

# Import modules for CGI handling
import cgi
import cgitb
import boto3
import requests
import json

cgitb.enable()

# Create instance of FieldStorage
form = cgi.FieldStorage()

# Get data from fields
song = form.getvalue("Song")
ccNuumb = form.getvalue("cc")
newItem = {"name": {}, "cc": {}}
newItem["name"]["S"] = song
newItem["cc"]["S"] = ccNuumb
capdata = form.getvalue("g-recaptcha-response")

client = boto3.client(
    "dynamodb",
    aws_access_key_id="AKIAWXNVJDBDIVQFTN3V",
    aws_secret_access_key="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",
    region_name="us-east-2",
)

print("Content-type:text/html\r\n\r\n")
print("<!doctype html><html>")
print("<head>")


def is_human(captcha_response):
    secret = "6Lcc6kAdAAAAABnaDlU84CH-Hx72-PafVD4BSXsN"
    payload = {"response": captcha_response, "secret": secret}
    response = requests.post("https://www.google.com/recaptcha/api/siteverify", payload)
    response_text = json.loads(response.text)
    return response_text["success"]


if is_human(capdata):

    print("<br>reCAPTCHA succeed!")

    response = client.describe_table(TableName="jukebox")
    response = client.put_item(TableName="jukebox", Item=newItem)

    print("<title>Hello - Second CGI Program</title>")
    print("</head>")
    print("<body>")
    print("<h2>SongName: %s <br>CCNumber: %s</h2>" % (song, ccNuumb))
    print("</body>")
    print("</html>")
else:
    print("<br>reCAPTCHA failed!")
