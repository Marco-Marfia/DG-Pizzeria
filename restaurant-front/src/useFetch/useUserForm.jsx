export const useUserForm = (url, body, setLogged, setUserData) => {

   let isLog = false;

   async function sendDataUser() {
      fetch(url, {
         method: 'POST',
         body: JSON.stringify(body),
         headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
         }
      }).then((res) => {
         if (res.status === 500) {
            alert('utente già creato')
            isLog = false
         } else if (res.status === 201) {
            isLog = true
            alert('utente creato')
         } else if (res.status === 400) {
            isLog = false
            alert('questa email è gia in uso')
         } else if (res.status === 404) {
            isLog = false
            alert('utente non trovato')
         } else if (res.status === 200) {
            isLog = true
            alert('utente trovato')
         }

         if (isLog) {
            setLogged(isLog)
         }
         return res.json()

      }).then(data => {
         if (isLog) {
            setUserData(data)
         }
      })
         .catch(error => {
            console.error('Errore: ' + error);
         })
   }
   sendDataUser(url, body, setLogged, setUserData);
}