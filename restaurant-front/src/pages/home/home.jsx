import './home.css'
import { FormLogin } from '../../components/form/formLogin/formLogin'
import { FormSignup } from '../../components/form/formSignup/formSignup'
import { FormContext } from '../../contexts/contexts'
import { useState } from 'react'
import { BtnsChangeForm } from '../../components/form/btnsChangeForm/btnsChangeForm'

export const Home = () => {

   const [change, setChange] = useState(false)
   const [errorsForm, setErrorsForm] = useState({})

   return (
      <>
            <section className='section-home m-5'>
               <img className='img-restaurant' src="/src/assets/img/sfondo-home.png" alt="delivery pizza" />
            </section>

            <section className='section-form d-flex flex-column justify-content-center align-items-center'>
               <FormContext.Provider value={{ changeForm: [change, setChange], errors: [errorsForm, setErrorsForm] }}>
                  <BtnsChangeForm />
                  {change ? <FormLogin /> : <FormSignup />}
               </FormContext.Provider>
            </section>
      </>
   )
}