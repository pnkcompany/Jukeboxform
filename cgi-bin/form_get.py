#!/usr/bin/python

# Import modules for CGI handling
import cgi
import cgitb
import boto3

cgitb.enable()

# Create instance of FieldStorage
form = cgi.FieldStorage()

# Get data from fields
song = form.getvalue("Song")
ccNuumb = form.getvalue("cc")


client = boto3.client('dynamodb', aws_access_key_id='AKIAWXNVJDBDIVQFTN3V',
                      aws_secret_access_key='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', region_name='us-east-2')

response = client.describe_table(TableName='jukebox')
# Print out some data about the table.
print(response)
newItem = {'name': {}, 'cc': {}}

newItem['name']['S'] = song
newItem['cc']['S'] = ccNuumb


response = client.put_item(
    TableName='jukebox',
    Item=newItem
)


print("Content-type:text/html\r\n\r\n")
print("<!doctype html><html>")
print("<head>")
print("<title>Hello - Second CGI Program</title>")
print("</head>")
print("<body>")
print("<h2>SongName: %s <br>CCNumber: %s</h2>" % (song, ccNuumb))
print("</body>")
print("</html>")
