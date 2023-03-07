import { useContext } from 'react'
import { FaShippingFast } from 'react-icons/fa'
import { GlobalContext } from '../../contexts/contexts'

export const Payment = () => {

   const { dataForm } = useContext(GlobalContext)
   const [ userData ] = dataForm

   return (

      <section className="p-5 text-center">
         <h2>{userData.username} l'ordine &#233; andato a buon fine</h2>
         <p>Il rider arriverà a breve</p>
         <FaShippingFast className='fs-1 mt-5 text-warning' />
      </section>

   )
}