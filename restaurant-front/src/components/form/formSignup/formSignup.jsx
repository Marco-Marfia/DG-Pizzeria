import '../style/form.css'
import { ValidationForm } from "../validationForm/validation";
import { useContext, useRef } from "react";
import { FormContext, GlobalContext } from "../../../contexts/contexts";
import { useUserForm } from "../../../useFetch/useUserForm";

export const FormSignup = () => {

   const email = useRef()
   const username = useRef()
   const password = useRef()

   const { errors } = useContext(FormContext)
   const { isLogged, dataForm } = useContext(GlobalContext)

   const [errorsForm, setErrorsForm] = errors
   const [logged, setLogged] = isLogged
   const [userData, setUserData] = dataForm

   //assegno i valori della form all'oggetto
   const handleInput = (e) => {
      setUserData({ ...userData, [e.target.name]: e.target.value })
   }

   const sendUserData = (errors) => {

      if (errors.email || errors.username || errors.password || !userData.email || !userData.username || !userData.password) {
         //non faccio nulla perchè escono già gli errori ma lo lascio altrimenti parte la fetch
      } else {
         useUserForm('http://localhost:8080/api/restaurant/user/create', userData, setLogged, setUserData)
         email.current.value = ''
         username.current.value = ''
         password.current.value = ''
      }
   }

   const handleValidation = (e) => {
      e.preventDefault()

      let errors = ValidationForm(userData)
      setErrorsForm(errors)
      sendUserData(errors)
   }

   return (

      <article className="form-container w-100 d-flex justify-content-center">

         <form onSubmit={handleValidation} className="form p-5 rounded mb-5 w-50">

            <h3 className="mb-4">Registrati</h3>

            <div className="form-group my-3">
               <input type="text" placeholder="email" ref={email} className="form-control" name="email" onChange={handleInput} />
               {errorsForm.email && <p className="errors">{errorsForm.email}</p>}
            </div>

            <div className="form-group my-3">
               <input type="text" placeholder="username" ref={username} className="form-control" name="username" onChange={handleInput} />
               {errorsForm.username && <p className="errors">{errorsForm.username}</p>}
            </div>

            <div className="form-group my-3">
               <input type="password" placeholder="password" ref={password} className="form-control" name="password" onChange={handleInput} />
               {errorsForm.password && <p className="errors">{errorsForm.password}</p>}
            </div>

            <button type="submit" className="btn btn-form">Registrati</button>

         </form>

      </article>
   );
}