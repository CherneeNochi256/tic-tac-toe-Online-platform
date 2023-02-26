import axios from 'axios'

const USER_BASE_URL = 'http://localhost:8080/users/'

class UserService{
    getSmt(){
        return axios.get(USER_BASE_URL+1)
    }
}


export default new UserService()