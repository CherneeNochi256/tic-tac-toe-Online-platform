<template>
  <div class="tic-tac-toe">
    <div id="details">
      <h1>Tic Tac Toe</h1>
    </div>
    <grid
        ref="childComponent"
        @win="addWin"
    ></grid>

  </div>
</template>

<script>
import UserService from '@/services/UserService'
import Grid from "@/components/Grid.vue";

export default {
  components: {
    UserService,
    Grid
  },
  data() {
    return {
      matches: 0,
      wins: {
        O: 0,
        X: 0
      }
    }
  },
  methods: {
    addWin(event) {

      if (event === 'O'){
        this.wins[event]++
      }else {
        this.wins["X"]++
      }
    }
  }
}
</script>

<style scoped>
body {
  background-color: #fff;
  color: #fff;
  font-family: 'Dosis', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin: 0px;
}

.tic-tac-toe {
  margin: 0 auto;
  max-width: 270px;
  color: #34495e;
}

h1 {
  text-transform: uppercase;
  font-weight: bold;
  font-size: 3em;
}

.restart {
  background-color: #e74c3c;
  color: #fff;
  border: 0px;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  font-family: 'Dosis', sans-serif;
  font-size: 1.4em;
  font-weight: bold;
  margin: 0px;
  padding: 15px;
  width: 100%;
}

.restart:hover {
  background-color: #c0392b;
  cursor: pointer;
}

.scoreBoard {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  height: 15px;
  background-color: #16a085;
  box-shadow: #2c3e50;
  padding: 20px;
  overflow-x: hidden;
}

.scoreBoard h2 {
  margin: 0px;
}

.scoreBoard span {
  float: right;
  font-size: 1.5em;
  font-weight: bold;
  margin-left: 20px;
}

</style>