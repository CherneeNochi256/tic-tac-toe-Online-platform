<template>
  <div >
    <div class="gameStatus" :class="gameStatusColor">
      {{gameStatusMessage}}
    </div>
    <table class="grid">
      <tr>
        <cell
            name="1"
            @strike="strike"
         frozen=""></cell>
        <cell
            name="2"
            @strike="strike"
         frozen=""></cell>
        <cell
            name="3"
            @strike="strike"
         frozen=""></cell>
      </tr>
      <tr>
        <cell
            name="4"
            @strike="strike"
         frozen=""></cell>
        <cell
            name="5"
            @strike="strike"
         frozen=""></cell>
        <cell
            name="6"
            @strike="strike"
         frozen=""></cell>
      </tr>
      <tr>
        <cell
            name="7"
            @strike="strike"
         frozen=""></cell>
        <cell
            name="8"
            @strike="strike"
         frozen=""></cell>
        <cell
            name="9"
            @strike="strike"
         frozen=""></cell>
      </tr>
    </table>

  </div>
</template>

<script>
import Cell from "@/components/Cell.vue";

export default {
  name: "Board",
  components: {Cell},
  data() {
    return {
      activePlayer: 'O',
      gameStatus: 'turn',
      gameStatusMessage: `O's turn`,
      gameStatusColor: 'statusTurn',
      moves: 0,
      cells: {
        1: '', 2: '', 3: '',
        4: '', 5: '', 6: '',
        7: '', 8: '', 9: ''
      },
      winConditions:
          [
            [1, 2, 3], [4, 5, 6], [7, 8, 9],
            [1, 4, 7], [2, 5, 8], [3, 6, 9],
            [1, 5, 9], [3, 5, 7]
          ],
    }
  },
  methods:{
    strike(cellNumber){
    this.cells[cellNumber] = this.activePlayer

      this.moves++

      this.gameStatus = this.changeGameStatus()

      this.changePlayer()
    },
    changeGameStatus() {

      if(this.checkForWin()){
        return this.gameIsWon()
      } else if(this.moves === 9){
        return 'draw'
      }

      return "turn";
    },
    changePlayer() {
      this.activePlayer = this.nonActivePlayer
    },
    checkForWin() {
      for(let i = 0; i< this.winConditions.length; i++){
        let wc = this.winConditions[i]
        let cells = this.cells

        if (this.areEqual(cells[wc[0]],cells[wc[1]],cells[wc[2]])){
          return true
        }
      }
      return false;
    },
    gameIsWon() {

      this.$emit('win', this.activePlayer)
      this.gameStatusMessage = `${this.activePlayer} Wins !!!!`
      this.$emit('freeze')

      return 'win';
    },
    areEqual(cell, cell2, cell3) {

      if (cell2 === '' || cell2 !== cell){
        return false
      } else  if (cell3 === '' || cell3 !== cell2){
        return false
      }


      return true;
    }
  },
  computed:{
    nonActivePlayer(){
      if (this.activePlayer === 'O'){
        return 'X'
      }
      return 'O'
    }
  },
  watch:{
    gameStatus(){
      if (this.gameStatus === 'win'){
        this.gameStatusColor = 'statusWin'

        this.gameStatusMessage = `${this.nonActivePlayer} Wins`

        return
      }else if (this.gameStatus === 'draw'){
        this.gameStatusColor = 'statusDraw'

        this.gameStatusMessage = 'Draw !'
        return
      }

      this.gameStatusMessage = `${this.activePlayer}'s turn`
    },
  },
}
</script>

<style scoped>
.grid {
  background-color: #34495e;
  color: #fff;
  width: 100%;
  border-collapse: collapse;
}

.gameStatus {
  margin: 0px;
  padding: 15px;
  border-top-left-radius: 20px;
  border-top-right-radius: 20px;
  background-color: #f1c40f;
  color: #fff;
  font-size: 1.4em;
  font-weight: bold;
}

.statusTurn {
  background-color: #f1c40f;
}

.statusWin {
  background-color: #2ecc71;
}

.statusDraw {
  background-color: #9b59b6;
}
</style>