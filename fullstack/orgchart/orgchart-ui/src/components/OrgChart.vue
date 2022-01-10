<template>
  <div>
    {{ employees }}
  </div>
  <div>
  <OrganizationChart :value="data">
      <template #default="slotProps">
          <span>{{slotProps.node.data.label}}</span>
      </template>
  </OrganizationChart>
  </div>
</template>

<script>
import { defineComponent, ref, onMounted, watch } from 'vue'
import { fetchData } from '@/http/rest.js'
import OrganizationChart from 'primevue/organizationchart';

export default defineComponent ({
  name: 'OrgChart',
  components: {OrganizationChart},
  setup() {
    const uri = '/employees'
    const employees = ref([])
    //const employee_org_chart = {}
    const data = {
                                 key: '0',
                                 data: {label: 'F.C. Barcelona'},
                                 children: [
                                     {
                                         key: '0_0',
                                         data: {label: 'F.C. Barcelona'},
                                         children: [
                                             {
                                                 key: '0_0_0',
                                                 data: {label: 'Chelsea F.C.'}
                                             },
                                             {
                                                 key: '0_0_1',
                                                 data: {label: 'F.C. Barcelona'}
                                             }
                                         ]
                                     },
                                     {
                                         key: '0_1',
                                         data: {label: 'Real Madrid'},
                                         children: [
                                             {
                                                 key: '0_1_0',
                                                 data: {label: 'Bayern Munich'}
                                             },
                                             {
                                                 key: '0_1_1',
                                                 data: {label: 'Real Madrid'}
                                             }
                                         ]
                                     }
                                 ]
                             }

    function fetchEmployees() {
      fetchData(uri, employees)
    }

    function findRoot() {
        return employees.value.filter(em => em.supervisor == null)
    }

    function sortEmployees() {
        let root_empl = findRoot();
        console.log(root_empl)
    }

    onMounted(() => {
      console.log('Mounting OrgChart')
      fetchEmployees()
      console.log('employees fetched')
      sortEmployees()
    })

    watch(employees, fetchEmployees)

    return {
      employees,
      data
    }
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
