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


cat data.txt | while read name cc
do
   sleep_time=`random $start_time $end_time`
   sleep $sleep_time 
   wget "http://localhost:8000/cgi-bin/form_get.py?Song=${name}&cc=${cc}&submit=Submit"
done