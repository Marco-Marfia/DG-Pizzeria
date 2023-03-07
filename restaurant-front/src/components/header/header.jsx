import './header.css'
import { Link } from 'react-router-dom'
import { FaShoppingCart, FaUser } from 'react-icons/fa'
import { useContext } from 'react'
import { GlobalContext } from '../../contexts/contexts'

export const Header = () => {

  const { numberCart, isLogged } = useContext(GlobalContext)
  const [numberHeader] = numberCart
  const [logged] = isLogged

  return (
    <header className='d-flex justify-content-between align-items-center'>

        <div className='img-container h-100'>
          <Link to={'/home'}>
            <img src="/src/assets/img/logo.png" alt="logo restaurant" className='h-100' />
          </Link>
        </div>

        <span className='list d-flex m-0'>
          <Link className='link-header align-items-center' to={'/home'}>Home</Link>
          <Link className='link-header' to={'/menu'}>Menu</Link>
          <Link className='link-header' to={'/cart-shopping'}>
            <FaShoppingCart />
            <span className='number-item-cart'>{numberHeader}</span>
          </Link>
          {logged ?
            <Link className='link-header' to={'/user-page'}> <FaUser /> </Link> :
            <Link className='pe-none ms-3'> <FaUser /> </Link>}
        </span>

    </header>
  )
}