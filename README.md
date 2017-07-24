install: git clone https://github.com/vladkucher/TelephoneDirectory


run: 

     1) создать базу данных phonebook для mysql;
     2) в файле application.properties, который лежит в resources укажите какой профиль использовать для хранения данных:
          spring.profiles.active=jsondata - если хранить данные в json файле,
          нужно указать свойство file.name: D:\\path\file.json в файле aplication-jsondata.properties
          spring.profiles.active=datajpa -профиль для хранения данных в БД
     3) mvn spring-boot:run 
     
Скрипты на создания БД в resources/db
  
