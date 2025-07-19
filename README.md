# 📢 Multithreaded Chat Application (Java Sockets)

This is a **console-based chat application** built using **Java Sockets and Multithreading**. Multiple users can chat with each other in real-time via the terminal.

---

## 🎥 Demo
![Chat Demo](https://github.com/Prajapatikapil41/Chat-application/blob/main/Codveda_L3T2.gif)
---
## ✅ Features

* 🔥 Multi-client support using multithreading
* 🖥️ Console-based chat interface
* 💬 Broadcast messages to all connected clients
* 🧹 Clean disconnection handling
* 🚪 Clients can exit the chat using `exit` command

---

## 📁 Project Structure

```
chat-application/
│
├── src/
│   ├── server/
│   │   ├── ChatServer.java
│   │   └── ClientHandler.java
│   └── client/
│       └── ChatClient.java
└── out/   <-- compiled .class files will go here
└── README.md
```

---

## ⚙️ How to Run the Application

### 1. Compile the Java Code

```bash
javac -d out src/server/*.java src/client/*.java
```

### 2. Start the Server

Open a terminal in the project root and run:

```bash
java -cp out server.ChatServer
```

✅ You will see:

```
Server started on port 1234
```

### 3. Start the Client (in a New Terminal)

```bash
java -cp out client.ChatClient
```

✅ It will ask for your name and you can start chatting.

### 4. Open Multiple Clients

Repeat step 3 in multiple terminals to simulate multiple users chatting.

---

## 📌 Example Flow

**Server terminal:**

```
Server started on port 1234
New client connected: Socket[addr=/127.0.0.1,...]
```

**Client terminal:**

```
Connected to chat server
Enter your name: John
John joined the chat.
```

Clients can send messages to each other in real-time.

---

## 🛑 How to Exit

To disconnect a client, simply type:

```
exit
```

✅ You will be disconnected from the server.

---

## 🧹 Clean Build Instructions (Optional)

To clean and recompile everything:

```bash
rm -rf out/
javac -d out src/server/*.java src/client/*.java
```

---

## 📝 Notes

* This is a **basic console chat app**, ideal for learning Java **Sockets** and **Multithreading**.
* You can extend it with GUI or WebSocket in future enhancements.

---

## 👨‍💻 Author

|                                                                                                     Photo                                                                                                    | **Kapil Prajapati**                                                                                                                                                                                                                                                 |
| :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| [<img src="https://avatars.githubusercontent.com/u/81869156?s=400&u=ff6de7017b51e4d96dbfb1ae39c7a459d5e13ea8&v=4" width="120" height="120" style="border-radius:50%;">](https://github.com/Prajapatikapil41) | - 🧑‍💻 **GitHub:** [Prajapatikapil41](https://github.com/Prajapatikapil41)<br> - 💼 **LinkedIn:** [Kapil LinkedIn](https://www.linkedin.com/in/kapil-prajapati-7ba4b51b7/)<br> - 📧 **Email:** [kapilprajapati0403@gmail.com](mailto:kapilprajapati0403@gmail.com) |

---
