import './userPage.css'
import { useContext } from "react"
import { Link } from "react-router-dom"
import { GlobalContext } from "../../contexts/contexts"
import { useGetOrders } from "../../useFetch/useGetOrders"

export const UserPage = () => {

   const { isLogged, dataForm } = useContext(GlobalContext)
   const [logged, setLogged] = isLogged
   const [ userData ] = dataForm

   const allOrders = useGetOrders('http://localhost:8080/api/restaurant/orders/user/find/' + userData.id)

   const logout = () => {
      setLogged(false)
   }

   return (

      <div className="p-3">
         <h2>Pagina personale dell' utente:</h2>

         <section className="d-flex justify-content-evenly my-5">

            <div>
               <h3 className="text-warning">Nome:</h3>
               <h5>{userData.username}</h5>
            </div>

            <div className="mb-5">
               <h3 className="text-warning">Email:</h3>
               <h5>{userData.email}</h5>
            </div>
         </section>

         <h3 className="text-warning ms-3">Ordini</h3>

         {allOrders.length ?
            <section className="ms-3 d-flex flex-wrap">
               {allOrders.map(order => {
                  return (
                     <div className="w-25 my-5 border border-warning p-3 rounded mx-3" key={order.id}>
                        <h4 className="text-danger">{order.id}</h4>

                        <ul className='ps-0'>
                           {order.foods.map((food, i) => {
                              return (
                                 <li key={i}>
                                    {food.name}
                                    <hr />
                                 </li>
                              )
                           })}
                        </ul>
                     </div>
                  )
               })}
            </section> :
            <h5 className="ms-3">non ci sono ordini</h5>
         }
         <Link className="btn btn-logout d-block w-25 m-auto my-5" onClick={() => logout()} to={'/home'}>Logout</Link>
      </div>
   )
}