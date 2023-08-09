new Vue({
  el: '#app',
  data() {
    return {
      info: null
    };
  },
  mounted() {
    axios
      .get('http://127.0.0.1:8080/v1/product')
      .then(response => (this.info = response));
  }
});