# SpeedTest

[![CircleCI](https://circleci.com/gh/icejester/SpeedTest.svg?style=svg)](https://circleci.com/gh/icejester/SpeedTest)

Simple Springboot application designed to run on a raspberry-pi. This application works in tandem with [pi-hubot](https://github.com/icejester/pi-hubot) also insalled on the raspberry-pi so a speed test and report can be executed and displayed in my personal slack team.

### doRecord
When invoked (`127.0.0.1:8080/doRecord`) this app will attempt to download a large file from the internet. It will keep track of how long it takes to download and calculate a download rate in mb/s and store the "last test" in memory.

### SpeedTest
When invoked (`127.0.0.1:8080/SpeedTest`) this app will report the download rate of the last speed test performed.