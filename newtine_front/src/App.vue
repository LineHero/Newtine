<script setup>
import { RouterLink, RouterView } from 'vue-router'
import TheHeaderView from '@/components/common/TheHeaderView.vue'
import TheFooterView from '@/components/common/TheFooterView.vue'
</script>

<template>
  <div class="wrapper">
    <TheHeaderView/>
  <main>
    <RouterView />
  </main>
  <TheFooterView/>
  </div>
</template>

<style scoped>
.wrapper {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
main {
  flex: 1;
}

</style>

<style>
@font-face {
    font-family: 'Freesentation-9Black';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2404@1.0/Freesentation-9Black.woff2') format('woff2');
    font-weight: 900;
    font-style: normal;
}

@font-face {
    font-family: 'Ownglyph_meetme-Rg';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2402_1@1.0/Ownglyph_meetme-Rg.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}

* { 
  font-family: 'Freesentation-9Black';
}

</style>