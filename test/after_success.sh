#!/bin/bash

curl -Lo travis_after_all.py https://raw.github.com/dmakhno/travis_after_all/master/travis_after_all.py
python travis_after_all.py https://api.travis-ci.org
export $(cat .to_export_back)

echo "TRAVIS_REPO_SLUG is $TRAVIS_REPO_SLUG"
echo "TRAVIS_BRANCH is $TRAVIS_BRANCH"
echo "TRAVIS_PULL_REQUEST is $TRAVIS_PULL_REQUEST"
echo "BUILD_LEADER is $BUILD_LEADER"
echo "BUILD_AGGREGATE_STATUS is $BUILD_AGGREGATE_STATUS"
  		  
if [ "$TRAVIS_REPO_SLUG" == 'NoraUi/noraui-archetype' ] && [ "$TRAVIS_BRANCH" == 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ] && [ "$BUILD_LEADER" == 'YES' ] && [ "$BUILD_AGGREGATE_STATUS" == 'others_succeeded' ]; then
    mvn_version=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.5.0:exec)
    echo "Maven version is $mvn_version"
    if [[ $mvn_version == *"-SNAPSHOT" ]]; then
        echo "******** Starting deploy snapshot"
        mvn clean deploy -Psnapshot --settings test/mvnsettings.xml -DskipTests=true
        exit $?
    fi
fi
