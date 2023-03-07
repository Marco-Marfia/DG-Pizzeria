export const ValidationForm = (values) => {

   let error = {}
   const nameRegex = /^[a-zA-Z]{3,}$/
   const emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
   const passwordRegex = /^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z0-9]).*$/

   if (values.email === '') {
      error.email = '*l\'email non può essere vuota'
   } else if (!emailRegex.test(values.email)) {
      error.email = '*l\'email non è corretta'
   }

   if (values.username === '') {
      error.username = '*il nome non può essere vuoto'
   } else if (!nameRegex.test(values.username)) {
      error.username = '*nel nome si possono scrivere solo lettere e devono essere almeno 3'
   }

   if (values.password === '') {
      error.password = '*la password non può essere vuota'
   } else if (!passwordRegex.test(values.password)) {
      error.password = '*la password deve contenere una lettera maiuscola, una minuscola, un numero ed un carattere speciale'
   }

   return error
}