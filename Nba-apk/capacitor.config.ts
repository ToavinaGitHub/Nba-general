import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.example.nbaapk',
  appName: 'nbaApk',
  webDir: 'build',
  server: {
    androidScheme: 'https'
  }
};

export default config;
