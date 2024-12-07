<template>
  <div class="schedule-container p-4">
    <div v-if="userData" class="mb-6">
      <h2 class="text-2xl font-bold">Schedule for {{ userData.name }}</h2>
      <p class="text-gray-600">{{ userData.course }}</p>
    </div>

    <div class="overflow-x-auto">
      <table class="min-w-full bg-white border border-gray-300">
        <thead>
          <tr class="bg-gray-100">
            <th class="border px-4 py-2 w-24">Time</th>
            <th class="border px-4 py-2">Monday</th>
            <th class="border px-4 py-2">Tuesday</th>
            <th class="border px-4 py-2">Wednesday</th>
            <th class="border px-4 py-2">Thursday</th>
            <th class="border px-4 py-2">Friday</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="time in timeSlots" :key="time" class="hover:bg-gray-50">
            <td class="border px-4 py-2 font-medium">{{ formatTimeDisplay(time) }}</td>
            <td v-for="day in ['M', 'T', 'W', 'TH', 'F']" :key="day" 
                class="border px-4 py-2 min-h-[60px]">
              <div v-if="getClassForTimeAndDay(time, day)" 
                   class="bg-blue-100 p-2 rounded">
                <div class="font-bold">{{ getClassForTimeAndDay(time, day).subject.subjectCode }}</div>
                <div class="text-sm">{{ getClassForTimeAndDay(time, day).sectionName }}</div>
                <div class="text-sm">{{ getClassForTimeAndDay(time, day).room.roomName }}</div>
                <div class="text-xs text-gray-600">
                  {{ getClassForTimeAndDay(time, day).instructors[0].instructorName }}
                </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const userData = ref(null);

// Generate time slots for every 30 minutes from 7:00 AM to 9:00 PM
const generateTimeSlots = () => {
  const slots = [];
  for (let hour = 7; hour <= 21; hour++) {
    // Time Formatting for 30-minute intervals
    slots.push(`${hour.toString().padStart(2, '0')}00`);
    slots.push(`${hour.toString().padStart(2, '0')}30`);
  }
  return slots;
};

const timeSlots = ref(generateTimeSlots());

// Format time for display
const formatTimeDisplay = (time) => {
  const hours = parseInt(time.substring(0, 2));
  const minutes = time.substring(2);
  const period = hours >= 12 ? 'PM' : 'AM';
  const displayHours = hours % 12 || 12;
  return `${displayHours}:${minutes} ${period}`;
};

// Check if a class occurs at a specific time and day
const getClassForTimeAndDay = (time, day) => {
  if (!userData.value?.sections) return null;
  
  return userData.value.sections.find(section => {
    const classStartTime = parseInt(section.timeStart);
    const classEndTime = parseInt(section.timeEnd);
    const currentTime = parseInt(time);
    
    // Check if the current time slot falls within the class time range
    const timeMatch = currentTime >= classStartTime && currentTime < classEndTime;
    const dayMatch = section.dayOfTheWeekSchedule.includes(day);
    
    return timeMatch && dayMatch;
  });
};

onMounted(async () => {
  try {
    const response = await axios.get('http://127.0.0.1:9997/user/retrieve', {
      params: {
        pk: 1
      }
    });
    userData.value = response.data;
  } catch (error) {
    console.error('Error fetching user data:', error);
  }
});
</script>

<style scoped>
.schedule-container {
  max-width: 1200px;
  margin: 0 auto;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  vertical-align: top;
}

td {
  height: 60px; 
}

.overflow-x-auto {
  overflow-x: auto;
  -webkit-overflow-scrolling: touch;
}

thead th:first-child,
tbody td:first-child {
  position: sticky;
  left: 0;
  background: white;
  z-index: 1;
}

thead th:first-child {
  background: #f3f4f6;
}

tr:nth-child(even) {
  background-color: #fafafa;
}

tr:hover td {
  background-color: #f3f4f6;
}
</style>