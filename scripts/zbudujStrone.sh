#!/bin/sh

echo 
./scripts/glassfish3/glassfish/bin/asadmin undeploy Ksiegarnia
echo 
mvn package
echo 
./scripts/glassfish3/glassfish/bin/asadmin deploy target/Ksiegarnia.war
