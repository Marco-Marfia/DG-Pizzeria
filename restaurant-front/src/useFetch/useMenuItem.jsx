import { useEffect, useState } from "react"

export const useMenuItem = (url) => {

   const [itemCard, setItemCard] = useState([])

   useEffect(() => {
      (async () => {
         const response = await fetch(url)
         setItemCard(await response.json())
      })()
   }, [])
   return itemCard;
}