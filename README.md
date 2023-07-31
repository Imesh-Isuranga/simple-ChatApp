
# Simple-ChatApp-JavaFX

This is a Java-based simple, efficient, and interactive client-server chat application that enables real-time communication between users connected to the same server. It facilitates seamless and instantaneous message exchange, making it ideal for small-scale chat environments.







## Key Features

#### Server Side:
The server side of your chatApp is responsible for handling incoming connections from multiple clients and facilitating message exchange between them. It creates a server socket that listens for incoming client connections and maintains a list of connected clients. When a client connects, the server assigns a unique identifier to the client and adds it to the list. It then continuously listens for messages from each client and broadcasts them to all connected clients, ensuring that the communication is relayed to everyone in the chat.

#### Client Side:
The client side of your chatApp allows users to join the chat and send messages to the server, which are then distributed to all other connected clients. Each client has a user interface where users can type messages and view the chat history. When a user sends a message, it is sent to the server, which, in turn, forwards the message to all other clients. The client program also receives incoming messages from the server and displays them on the user interface, allowing users to participate in the chat.


## Installation

Run the Serverside application and Clientside application separately.
