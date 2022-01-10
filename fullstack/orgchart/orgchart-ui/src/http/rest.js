import axios from 'axios'

export function fetchData(uri, dataRef) {
    axios.get(uri)
        .then((res) => dataRef.value = res.data)
        .catch((err) => console.log(err))
}

export function postData(uri, formData) {
    axios.post(uri, formData)
        .catch((err) => console.log(err))
}

