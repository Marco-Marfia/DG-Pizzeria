import { useEffect, useState } from "react"

export const useGetOrders = (url) => {

   const [orders, setOrders] = useState([])

   useEffect(() => {
      (async () => {
         const response = await fetch(url)
         setOrders(await response.json())
      })()
   }, [])
   return orders
}