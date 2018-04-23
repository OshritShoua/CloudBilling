import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

// ===================== Pages Components ======================
// import Navbar from './components/Navbar'
import MainPanel from './components/MainPanel'
import Signup from './components/Signup'
import About from './components/About'
import ContactUs from './components/ContactUs'

// ==================== Router registration ====================
export default new Router({
  mode: 'hash',
  routes: [
    { path: '/', component: MainPanel },
    { path: '/signup', component: Signup },
    { path: '/about', component: About },
    { path: '/contact-us', component: ContactUs }
  ]
})
