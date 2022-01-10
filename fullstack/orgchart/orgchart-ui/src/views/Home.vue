<template>
  <div class="home">
    <OrgChart/>
  </div>
</template>

<script>
// @ is an alias to /src
import OrgChart from '@/components/OrgChart.vue'

export default {
  name: 'Home',
  components: {
    OrgChart
  }
}
</script>
