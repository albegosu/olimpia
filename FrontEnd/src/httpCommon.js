import axios from "axios";

export default axios.create({
    baseURL:"http://localhost:3310",
    headers: {
        "Content-type": "application/json"
    }

})
