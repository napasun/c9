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

## 2.html

```html
//요소 속성 바인딩
<body>
    <div id="app-2">
        <span v-bind:title="message">
            마우스를 올리면 동적으로 선언된 메시지를 볼 수 있습니다.!
        </span>
    </div> ㅇ
</body>


<script>
    var app2 = new Vue({
        el: '#app-2',
        data: {
            message: 'You loaded this page on ' + new Date().toLocaleString()
        }
    })
</script>
```