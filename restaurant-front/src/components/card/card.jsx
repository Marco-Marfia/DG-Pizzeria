import './card.css'
import React, { useContext } from 'react'
import { GlobalContext } from '../../contexts/contexts'
import { useMenuItem } from '../../useFetch/useMenuItem.jsx'

export const Card = () => {

   const allFoodFetch = useMenuItem('http://localhost:8080/api/restaurant/food/all')

   const { numberCart, itemCart } = useContext(GlobalContext)
   const [numberHeader, setNumberHeader] = numberCart
   const [item, setItem] = itemCart

   const grow = (e) => {
      e.currentTarget.classList.add('grow')
   }

   const normal = (e) => {
      e.currentTarget.classList.remove('grow')
   }

   const itemsInCart = (el) => {
      setItem([...item, el])
   }

   return (
      <>
         {allFoodFetch.length === 0 ? <img src="/src/assets/svg/Loading.svg" alt="caricamento menù" /> : null}

         {allFoodFetch.map((el) => {
            return (
               <div onMouseEnter={grow} onMouseLeave={normal} className="card w-25" key={el.id}>

                  <img src={el.imgPath} className="card-img-top h-50" alt={el.name} />

                  <div className="card-body">
                     <h5 className="card-title ">{el.name}</h5>
                     <h6 className="card-subtitle text-dark mb-2">{el.price.toFixed(2)}&#8364;</h6>
                     <p className="card-text text-dark">{el.description}</p>
                     <button onClick={() => [setNumberHeader(numberHeader + 1), itemsInCart(el)]} className="btn btn-success">aggiungi</button>
                  </div>

               </div>
            )
         })}
      </>
   )
}