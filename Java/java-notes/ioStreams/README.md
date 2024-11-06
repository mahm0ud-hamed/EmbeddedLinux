# io streams 

- if data is out from application we need output stream 

- if daat from media to application we need input stream 

- types of stream 
    - low level stream 
        - bytes 
            - file input stream 
            - file output stream
        - character 
            - file reader 
            -  file writer 
        - R/W random access file access file from any location in file "statr, end "
        it will act as read write 
    - high level stream 
        - data input stream 
        - data output stream 
        **you will need an low level stream to work with high level stream , just create object form low level**

- whe you try to read using high level stream you should read with the same schema same order and using high level stream 