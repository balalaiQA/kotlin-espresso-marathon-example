# kotlin-espresso-marathon-example
Kotlin + Espresso + Marathon UI tests automation example for multiple targets

## Setup:

##### Linux:
Grab the latest release from [GitHub Releases](https://github.com/Malinskiy/marathon/releases) page. Extract the archive into your apps folder and add the binary to your path using local terminal session or using your profile file (.bashrc or equivalent), e.g.

```
unzip -d $DESTINATION marathon-X.X.X.zip
export PATH=$PATH:$DESTINATION/marathon-X.X.X/bin
```
##### MacOS:
```
brew tap malinskiy/tap
brew install malinskiy/tap/marathon
```

## Build app and tests:
```
./gradlew assembleTargetOneDebug
./gradlew assembleTargetOneDebugAndroidTest
```

## Run tests:
```
marathon -m Marathonfile-targetOne.yaml
```

## Report:
```
cd marathon
allure serve
```
