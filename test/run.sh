#!/usr/bin/env bash

#
# display chrome version used on Travis-ci
google-chrome --version

cd $(dirname $0)
pwd
ls -l
cd ..
pwd
ls -l
echo "*******************************************"
echo "*                                         *"
echo "*    install of Maven noraui-archetype    *"
echo "*                                         *"
echo "*******************************************"
mvn clean install -B

mkdir generate_app
cd generate_app
echo "************************************************"
echo "*                                              *"
echo "*    generate a robot from noraui-archetype    *"
echo "*                                              *"
echo "************************************************"
mvn archetype:generate -B -DarchetypeGroupId=com.github.noraui -DarchetypeArtifactId=noraui-archetype -DarchetypeVersion=4.3.0.0-SNAPSHOT -DgroupId=com.your.company -DartifactId=robot -Dversion=0.0.1-SNAPSHOT -DinteractiveMode=false

pwd
ls -l
cd robot
echo "**********************************************************"
echo "*                                                        *"
echo "*    run and test robot generated by noraui-archetype    *"
echo "*                                                        *"
echo "**********************************************************"
mvn clean test javadoc:javadoc -B -Dcucumber.options="--tags '@loginLogout or @playToLogoGame or @jouerAuJeuDesLogos or @search'" -Pjavadoc,drivers,preIC,scenarioInitiator,ci,unit-tests,postIC --settings ../../test/mvnsettings.xml -Dmaven.test.failure.ignore=true -Dcrypto.key=${CRYPTO_KEY}

curl -s "https://api.travis-ci.org/jobs/${TRAVIS_JOB_ID}/log.txt?deansi=true" > nonaui.log
sleep 15

echo "Log url is https://api.travis-ci.org/jobs/${TRAVIS_JOB_ID}/log.txt?deansi=true"
echo "***************************************************"

counters1=$(sed -n 's:.*<EXPECTED_RESULTS_1>\(.*\)</EXPECTED_RESULTS_1>.*:\1:p' nonaui.log | head -n 1)
echo "******** $counters1"
nb_counters1=$(sed -n ":;s/$counters1//p;t" nonaui.log | sed -n '$=')
echo "********" found $nb_counters1 times

counters2=$(sed -n 's:.*<EXPECTED_RESULTS_2>\(.*\)</EXPECTED_RESULTS_2>.*:\1:p' nonaui.log | head -n 1)
echo "******** $counters2"
nb_counters2=$(sed -n ":;s/$counters2//p;t" nonaui.log | sed -n '$=')
echo "******** found $nb_counters2 times"

echo "***************************************************"

# check if BUILD FAILURE finded in logs
nb_failure=$(sed -n ":;s/BUILD FAILURE//p;t" nonaui.log | sed -n '$=')
if [ "$nb_failure" != "" ]; then
    echo "******** BUILD FAILURE find $nb_failure time in build"
    exit 255
fi

# 2 = 1 (real) + 1 counter (Excel)
if [ "$nb_counters1" == "2" ]; then
    echo "******** All counter is SUCCESS"
else
    echo "******** All counter is FAIL"
    exit 255
fi
if [ "$nb_counters2" == "2" ]; then
    echo "******** All counter is SUCCESS"
else
    echo "******** All counter is FAIL"
    exit 255
fi

exit 0
