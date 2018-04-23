<template>
  <div>
  <form v-if="!signed" class="form-horizontal" >
    <fieldset>
      <div id="legend">
        <legend class="">Register</legend>
      </div>
      <div class="control-group">
        <label class="control-label" for="firstName">First Name</label>
        <div class="controls">
          <input v-model="user.firstName" type="text" id="firstName" name="firstName" placeholder="" class="input-xlarge">
          <p class="help-block">Username can contain any letters or numbers, without spaces</p>
        </div>
      </div>
       <div class="control-group">
        <label class="control-label" for="surname">Surname</label>
        <div class="controls">
          <input v-model="user.surname" type="text" id="surname" name="surname" placeholder="" class="input-xlarge">
          <p class="help-block">Username can contain any letters or numbers, without spaces</p>
        </div>
      </div>

      <div class="control-group">
        <label class="control-label" for="username">User Name</label>
        <div class="controls">
          <input v-model="user.username" type="text" id="username" name="username" placeholder="" class="input-xlarge">
          <p class="help-block">Username can contain any letters or numbers, without spaces</p>
        </div>
      </div>

      <div class="control-group">
        <label class="control-label" for="email">E-mail</label>
        <div class="controls">
          <input v-model="user.email" type="text" id="email" name="email" placeholder="" class="input-xlarge">
          <p class="help-block">Please provide your E-mail</p>
        </div>
      </div>

      <div class="control-group">
        <label class="control-label" for="password">Password</label>
        <div class="controls">
          <input v-model="user.password" type="password" id="password" name="password" placeholder="" class="input-xlarge">
          <p class="help-block">Password should be at least 4 characters</p>
        </div>
      </div>

      <div class="control-group">
        <!-- Button -->
        <div class="controls">
          <a @click="register" class="btn btn-success">Register</a>
        </div>
      </div>
    </fieldset>
    <br>
    <div v-if="creationError"> {{creationErrorMessage}} </div>
  </form>
    <div v-if="signed"> You are signed to the website! </div>
  </div>
</template>

<script type="text/javascript">
  export default {
    name: 'sign-up',
    data () {
      return {
        signed : false,
        creationError : false,
        creationErrorMessage : '',
        user : {
          firstName : '',
          surname : '',
          username : '',
          email : '',
          password : ''
        }
      }
    },
    created : function () {
      if (localStorage.getItem('loggedIn') && localStorage.getItem('username')) {
        this.signed = true;
      } else {
        this.signed = false;
      }
    } ,
    methods : {
      register() {
        var url = 'http://localhost:8081/signup';

        this.$http.post(url, this.user).then((res) => {
          console.log(res);
        this.creationError = false;
          this.signed=true;
        }, (err) => {
          console.log(err);
          this.signed=false;
          this.creationError = true;
          this.creationErrorMessage = err.bodyText;
        })
      }
    }
  }
</script>
