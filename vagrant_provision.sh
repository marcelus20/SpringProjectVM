#!/usr/bin/env bash

# Creating base for apps
mkdir -p ~/.apps/languages
mkdir -p ~/.apps/builders

# Editing .bashrc
echo "" >> ~/.bashrc
echo "#MODS" >> ~/.bashrc
echo "APPS=\$HOME/.apps" >> ~/.bashrc
echo "LANGUAGE=\$APPS/languages" >> ~/.bashrc
echo "BUILDER=\$APPS/builders" >> ~/.bashrc
echo "" >> ~/.bashrc

# Downloading and installing Java
java_url=http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-linux-x64.tar.gz

wget -q --no-check-certificate -c --header "Cookie: oraclelicense=accept-securebackup-cookie" $java_url &&
tar xzf jdk-8u181-linux-x64.tar.gz &&
mv jdk1.8.0_181 .apps/languages/jdk180_181 &&
echo "export JAVA_HOME=\$LANGUAGE/jdk180_181" >> ~/.bashrc &&
rm -rf jdk-8u181-linux-x64.tar.gz && echo "Java installed" &&

# Downloading and installing Maven
maven_url=http://ftp.man.poznan.pl/apache/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz

wget -q $maven_url &&
tar xzf apache-maven-3.5.4-bin.tar.gz &&
mv apache-maven-3.5.4 .apps/builders/apache_maven_354 &&
echo "export MAVEN_HOME=\$BUILDER/apache_maven_354" >> ~/.bashrc &&
rm -rf apache-maven-3.5.4-bin.tar.gz && echo "Maven installed" &&

# Finishing PATH variable
echo "" >> ~/.bashrc &&
echo "export PATH=\$PATH:\$JAVA_HOME/bin:\$MAVEN_HOME/bin" >> ~/.bashrc &&

source ~/.bashrc &&

# Installing and configuring postgres
yes | sudo pacman -Syy &&
yes | sudo pacman -S archlinux-keyring &&
yes | sudo pacman -Syu postgresql &&
mkdir -p /var/lib/postgres/data &&
sudo chown -R postgres:postgres /var/lib/postgres &&

sudo su - postgres -c "initdb -D '/var/lib/postgres/data'" &&

sudo systemctl start postgresql.service &&
sudo systemctl enable postgresql.service &&

#sudo su - postgres -c "pg_ctl -D /var/lib/postgres/data -l logfile start" &&
sudo su - postgres -c "createuser marcelus" &&
sudo su - postgres -c "createdb financialDb"