Örnek projemizde, event-driven mikroservis mimarisinde yazılmış, docker üzerinde publish edilebilecek 2 farklı RESTful servis bekliyoruz.

A servisinin mimari üzerinde "producer" olarak konumlandırılması ve kendisine gelen verileri önce DB’deki Users tablosuna kaydetmesi ve ardından veri modelindeki Id ve FollowerList propertylerini Message Broker'a aktarması gerekmektedir.

B servisinin mimari üzerinde "consumer" olarak konumlandırması ve A servisinin beslediği Message Broker'daki verileri asenkron olarak okuyarak DB'deki UserFollowers tablosuna yazması gerekmektedir.

# Kullanmanızı beklediğimiz teknolojiler; 

Servis Framework: Spring Boot

Message Broker: Apache Kafka

DB: Cassandra

# Örnek veri modeli:

Id => int

Name => string

Surname => string

FollowerList => int[]

CratedAt => DateTime