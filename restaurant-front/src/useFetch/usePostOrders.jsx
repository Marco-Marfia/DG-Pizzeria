export const usePostOrders = (url, body) => {

   async function sendOrder() {
      fetch(url, {
         method: 'POST',
         body: JSON.stringify(body),
         headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
         }
      })
         .catch(error => {
            console.error('errore', error);
         })
   }
   sendOrder(url, body)
}