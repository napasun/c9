## 1.html

```html
<body>
    <div id="app">
        {{ message }}
    </div>
</body>
<script>
    var app = new Vue({
        el: '#app', //아이디
        data: {     //데이터 설정
            message: 'Hello Vue!'   //값 설정
        }
    })
</script>
```