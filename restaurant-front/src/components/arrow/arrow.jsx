import './arrow.css'
import { FaArrowCircleUp } from 'react-icons/fa'
import { useEffect, useState } from 'react'

export const ArrowToTop = () => {

   const [arrow, setArrow] = useState(false)

   useEffect(() => {
      window.addEventListener('scroll', () => {
         if (window.scrollY > 300) {
            setArrow(true)
         } else {
            setArrow(false)
         }
      })
   })

   const goToTop = () => {
      window.scrollTo({ top: 0, behavior: 'smooth' })
   }

   return (
      <>
         {arrow && (
            <span className="arrow fs-1">
               <FaArrowCircleUp onClick={() => goToTop()} />
            </span>
         )}
      </>
   )
}