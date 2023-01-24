Prima di eseguire il programma occorre crearsi un istanza postgres

Comando:
docker run --name postgres-dbname -d -p 5432:5432 -e POSTGRES_PASSWORD=password postgres

Cambiare eventuali dati di collegamento su "src\main\webapp\WEB-INF\web.xml"

Leggere https://ddbdev.gitbook.io/payara/initialize/walkthrough/docker#dockerfile per pubblicare le porte esposte sul DockerFile
