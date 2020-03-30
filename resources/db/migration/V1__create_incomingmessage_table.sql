create TABLE INCOMINGMESSAGES (
    id serial primary key,
    username varchar(100),
    ipAddress varchar(100),
    message varchar(1000)
)