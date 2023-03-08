import './cart-shopping.css'
import { useContext } from 'react'
import { FaCartPlus } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import { GlobalContext } from '../../contexts/contexts'
import { usePostOrders } from '../../useFetch/usePostOrders';

export const CartShopping = () => {

   let totalPrice = 0;

   const { numberCart, itemCart, isLogged, dataForm } = useContext(GlobalContext)
   const [numberHeader, setNumberHeader] = numberCart
   const [userData] = dataForm
   const [item] = itemCart
   const [logged] = isLogged

   const removeNumberHeader = (numberHeader) => {
      if (numberHeader > 0) {
         setNumberHeader(numberHeader - 1)
      }
   }

   const removeItem = (i) => {
      item.splice(i, 1)
   }

   const toFormLogin = () => {
      alert('devi loggarti prima di poter acquistare')
   }

   const saveOrder = () => {
      let order = { user: { id: userData.id }, foods: item }
      usePostOrders('http://localhost:8080/api/restaurant/orders/create', order)
      item.length = 0
      setNumberHeader(0)
   }

   return (
      <>
         {item.length ?
            <ul>
               {item.map((el, i) => {
                  { totalPrice += el.price }
                  return (

                     <li key={i} className='w-100 row my-4 align-items-center border rounded border-cart p-2'>
                        <span className='col-4'>
                           <img src={el.imgPath} alt={el.name} className='w-75 rounded' />
                           <h3 className='text-white'>{el.name}</h3>
                           <button onClick={() => [removeNumberHeader(numberHeader), removeItem(i)]} className="btn btn-remove">remove</button>
                        </span>
                        <p className='col-3 d-flex justify-content-center text-white'>{el.price.toFixed(2)} &#8364;</p>
                        <p className='col-5 d-flex justify-content-center text-white'>{el.description}</p>
                     </li>
                  )
               })}
               <h4 className='mt-5'>total price: {totalPrice.toFixed(2)} &#8364;</h4>
               {logged ?
                  <Link className='btn btn-outline-light btn-add' to={'/pay'} onClick={() => saveOrder()}>acquista</Link> :
                  <Link className='btn btn-outline-light btn-add' to={'/home'} onClick={() => toFormLogin()}>acquista</Link>
               }
            </ul>
            :
            <div className='text-center my-5'>
               <h2>il tuo carrello è vuoto</h2>
               <p>Torna al men&#249; per ordinare qualcosa</p>
               <div className='my-5 fs-1'>
                  <FaCartPlus />
               </div>
               <Link className='btn btn-menu btn-outline-warning' to={'/menu'}>menu</Link>
            </div>
         }
      </>
   )
}