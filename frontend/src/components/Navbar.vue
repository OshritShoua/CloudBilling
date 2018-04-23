<template>
<div>
<div>
    <div class="navbar  navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <router-link to="/" class="navbar-brand">CLOUD BILLING</router-link>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
          <!--<ul class="nav navbar-nav">-->
            <!--<li>-->
              <!--<router-link to="/" >Cloud World Blog</router-link>-->
            <!--</li>-->
          <!--</ul>-->
          <ul class="nav navbar-nav">
            <li>
              <router-link to="/about" >About</router-link>
            </li>
          </ul>
          <ul class="nav navbar-nav">
            <li>
              <router-link to="/contact-us" >Contact Us</router-link>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><router-link to="/signup" class="nav-item nav-link"> Sign Up </router-link></li>
          </ul>
        </div>
      </div>
    </div>
    <img id="banner" src="../assets/banner.png" class="img-responsive" alt="Responsive image">
    </div>
</div>
</template>

<script>
  export default {
  }
</script>

<style type="text/css">
  #banner {
    margin-top: 70px;
  }
</style>
