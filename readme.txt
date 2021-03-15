Tutorial link:
    - https://medium.com/@mailshine/activemq-getting-started-with-springboot-a0c3c960356e


Note:
    - There are two type of message in activemq:
        - Queue: Point to Point (only one consumer get message)
        - Topic: Broadcast (Multiple consumer get message)

TODO:
    - Check message queue is sent to all consumers or only one (In the doc, it said Point-To-Point(Mean only one get it)),
    However, as tested, all consumers received the message.