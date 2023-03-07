import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Footer } from './components/footer/footer'
import { Header } from './components/header/header'
import { Home } from './pages/home/home'
import { Menu } from './pages/menu/menu'
import { CartShopping } from './pages/cart-shopping/cart-shopping'
import { NotFound } from './pages/not-found/not-found';
import { GlobalContext } from './contexts/contexts';
import { useState } from 'react';
import { UserPage } from './pages/user-page/userPage';
import { Payment } from './pages/payment/payment';
import { ArrowToTop } from './components/arrow/arrow';

export const App = () => {

  //pizze da aggiungere/rimuovere nel carrello
  const [item, setItem] = useState([])
  const [logged, setLogged] = useState(false)
  const [order, setOrder] = useState([])
  const [userData, setUserData] = useState({})
  const [numberHeader, setNumberHeader] = useState(0)

  return (

    <GlobalContext.Provider value={{ numberCart: [numberHeader, setNumberHeader], itemCart: [item, setItem], isLogged: [logged, setLogged], orders: [order, setOrder], dataForm: [userData, setUserData] }}>
      <Router>

        <Header />

        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/home' element={<Home />} />
          <Route path='/menu' element={<Menu />} />
          <Route path='/cart-shopping' element={<CartShopping />} />
          <Route path='/user-page' element={<UserPage />} />
          <Route path='/pay' element={<Payment />} />
          <Route path='*' element={<NotFound />} />
        </Routes>

        <ArrowToTop />

        <Footer />

      </Router>
    </GlobalContext.Provider>
  )
}