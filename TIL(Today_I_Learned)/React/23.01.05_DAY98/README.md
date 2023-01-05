# 1. Mongo DB

### 터미널을 이용해 npm 설정

```bash
npm i nodemon
npm i mongodb
npm i express
```

### server.js코드

```jsx
const express = require('express')
const app = express();

const MongoClient = require('mongodb').MongoClient;
MongoClient.connect('mongodb+srv://<id>:<password>@cluster0.jq7efgh.mongodb.net/?retryWrites=true&w=majority',
    (err, client)=>{
    
    app.listen(7000, ()=>{
        console.log('listening 7000'); //포트번호 7000을 통해 cors 해결
    })

    app.get('/', (req, resp)=>{
        resp.sendFile(__dirname + '/index.html')
    })

})
```

이후 index.html을 만든후 [localhost:7000](http://localhost:7000) 잘 들어가지면 완료!