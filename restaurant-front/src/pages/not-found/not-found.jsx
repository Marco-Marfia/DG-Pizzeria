import './not-found.css'
import { FaSearch } from "react-icons/fa"
import { Link } from "react-router-dom"

export const NotFound = () => {
   
   return (
      <section className="page-not-found">

         <div className="content-not-found">
            <h4>ops.. forse la pagina che stai cercando non esiste</h4>
            <Link to={'/'} className="text-warning">Torna alla home</Link>
            <div className="search d-flex justify-content-center mt-5"><FaSearch /></div>
         </div>
         
      </section>
   )
}