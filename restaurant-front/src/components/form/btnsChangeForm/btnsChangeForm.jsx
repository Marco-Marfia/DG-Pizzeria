import { useContext } from "react"
import { FormContext } from "../../../contexts/contexts"

export const BtnsChangeForm = () => {

   const { changeForm } = useContext(FormContext)
   const [change, setChange] = changeForm

   return (
      <div className="mb-2">
         {change ?
            <button className="btn btn-change" onClick={() => setChange(false)}>Registrati</button> :
            <button className="btn btn-change" onClick={() => setChange(true)}>Login</button>
         }
      </div>
   )
}