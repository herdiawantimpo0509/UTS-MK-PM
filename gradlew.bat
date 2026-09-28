@echo off
rem Android Studio can use its configured Gradle distribution.
rem This file is included for project completeness.
if exist "%~dp0gradle\wrapper\gradle-wrapper.jar" (
  java -jar "%~dp0gradle\wrapper\gradle-wrapper.jar" %*
) else (
  echo Gradle wrapper JAR is not included in this package. Please use Android Studio Gradle sync/build.
  exit /b 1
)
