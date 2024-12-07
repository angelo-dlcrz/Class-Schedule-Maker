<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <header>
    <div class="nav-container">
      <nav>
        <div class="nav-left">
          <RouterLink to="/" class="home-link">Class Schedule Maker</RouterLink>
        </div>
        <div class="nav-right">
          <RouterLink to="/schedule">Schedule</RouterLink>
          <RouterLink to="/schedule-creation">Create Schedule</RouterLink>
          <RouterLink to="/created-schedule">Created Schedule</RouterLink>
        </div>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: none;
  padding: 1rem 0;
  background: var(--color-background-soft);
  border-bottom: 1px solid var(--color-border);
  width: 100vw;
  position: relative;
  left: 50%;
  right: 50%;
  margin-left: -50vw;
  margin-right: -50vw;
}

.nav-container {
  width: 100%;
  margin: 0 auto;
}

nav {
  width: 100%;
  font-size: 1rem;
  padding: 0.5rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.nav-left {
  flex-shrink: 0;
  margin-left: 8rem;
}

.nav-right {
  display: flex;
  gap: 2rem;
  margin-right: 8rem;
}

.home-link {
  font-size: 1.2rem;
  font-weight: 600;
}

nav a {
  display: inline-block;
  padding: 0.5rem 1rem;
  border-radius: 0.25rem;
  color: var(--color-text);
  text-decoration: none;
  transition: all 0.3s ease;
}

nav a:hover {
  background-color: var(--color-background-mute);
  transform: translateY(-1px);
}

nav a.router-link-active {
  background-color: var(--vt-c-green);
  color: var(--vt-c-white);
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
  }

  nav {
    padding: 0.5rem;
    margin-top: 0;
  }
}
</style>