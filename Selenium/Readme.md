
## CronJob setup runs every min and grabs the UI device to pop up the browser
\* \* \* \* \* export DISPLAY=:1 && source /Users/youruser/.bashrc && java -cp .:/Users/youruser/Documents/sele/dos-attack-cronjob/selenium-server-standalone-4.0.0-alpha-2.jar DosAttack >> log.log 2>&1
